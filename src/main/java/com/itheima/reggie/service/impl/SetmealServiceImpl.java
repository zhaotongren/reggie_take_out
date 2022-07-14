package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.common.CustomException;
import com.itheima.reggie.dto.SetmealDto;
import com.itheima.reggie.entity.Setmeal;
import com.itheima.reggie.entity.SetmealDish;
import com.itheima.reggie.mapper.SetmealMapper;
import com.itheima.reggie.service.SetmealDishService;
import com.itheima.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {

    @Autowired
    private SetmealDishService setmealDishService;

    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     *
     * @param setmealDto
     */
    @Transactional
    public void saveWithDish(SetmealDto setmealDto) {
        //保存套餐的基本信息，操作setmeal，执行insert操作
        this.save(setmealDto);

        //保存套餐和菜品的关系表的基本信息，操作setmeal_dish，执行insert操作
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        /*setmealDishes = setmealDishes.stream().map(item -> {
            iteam.setSetmealId(setmealDto.getId());
            //return item;
        }).collect(Collectors.toList());*/

        //ArrayList<SetmealDish> dishes = new ArrayList<>();
        for (SetmealDish setmealDish : setmealDishes) {
            setmealDish.setSetmealId(setmealDto.getId());
        }

        setmealDishService.saveBatch(setmealDishes);

    }

    /**
     * 删除套餐，同时删除套餐和菜品的关联数据
     *
     * @param ids
     */
    @Transactional
    public void romoveWithDish(List<Long> ids) {
        //select count(*) from setmeal where id in (1,2,3) and status = 1
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Setmeal::getId, ids);
        queryWrapper.eq(Setmeal::getStatus, 1);

        int count = this.count(queryWrapper);
        if (count > 0) {
            throw new CustomException("套餐正在售卖中，不能删除");
        }

        this.removeByIds(ids);

        //删除套餐菜品关系表相关数据
        LambdaQueryWrapper<SetmealDish> queryWrapper2=new LambdaQueryWrapper<>();
        queryWrapper2.in(SetmealDish::getSetmealId,ids);
        setmealDishService.remove(queryWrapper2);

    }
}
