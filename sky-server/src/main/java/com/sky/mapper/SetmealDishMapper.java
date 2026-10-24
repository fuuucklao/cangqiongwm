package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    List<Long> getSetmealDishIdsBySetmealId(List<Long> dishIds);

    void insertBatch(List<SetmealDish> setmealDishes);

    @Select("select * from setmeal_dish where setmeal_id = #{setmealIds}")
    List<SetmealDish> getBySetmealId(Long setmealIds);

    void deleteBySetmealIds(List<Long> setmealIds);

    @Delete("delete from setmeal_dish where setmeal_id = #{setmealId}")
    void deleteBySetmealId(Long setmealId);

    @Select("select d.status from setmeal_dish s left join dish d on s.dish_id = d.id where d.id = #{dishId}")
    Integer getDishStatus(Long dishId);
}
