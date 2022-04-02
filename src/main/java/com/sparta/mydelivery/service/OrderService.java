package com.sparta.mydelivery.service;

import com.sparta.mydelivery.dto.FoodOrderDto;
import com.sparta.mydelivery.dto.FoodOrderRequestDto;
import com.sparta.mydelivery.dto.OrderRequestDto;
import com.sparta.mydelivery.models.Food;
import com.sparta.mydelivery.models.FoodOrder;
import com.sparta.mydelivery.models.OrderList;
import com.sparta.mydelivery.repository.FoodOrderRepository;
import com.sparta.mydelivery.repository.FoodRepository;
import com.sparta.mydelivery.repository.OrderRepository;
import com.sparta.mydelivery.repository.RestaurantsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final FoodOrderRepository foodOrderRepository;
    private final FoodRepository foodRepository;
    private final RestaurantsRepository restaurantsRepository;

    public OrderList readOrders(OrderRequestDto requestDto) {
        int howmanyOrder = requestDto.getFoods().size();
        int quantity = 0;
        int totalPrice = 0;
        int price = 0;

        List<FoodOrder> foodOrders = new ArrayList<>();
        Long restaurantId = requestDto.getRestaurantId();
        String restaurantName = restaurantsRepository.findRestaurantsById(restaurantId).getName();
        int deliveryFee = restaurantsRepository.findRestaurantsById(restaurantId).getDeliveryFee();

        for(int i = 0; i < howmanyOrder; i++){
            FoodOrderRequestDto foodOrderRequestDto = requestDto.getFoods().get(i);
            quantity = foodOrderRequestDto.getQuantity();
            price = foodRepository.findByIdAndRestaurantsId(foodOrderRequestDto.getId(), restaurantId).getPrice();
            String foodName = foodRepository.findByIdAndRestaurantsId(foodOrderRequestDto.getId(), restaurantId).getName();
            FoodOrderDto foodOrderDto = new FoodOrderDto();
            foodOrderDto.setName(foodName);
            foodOrderDto.setQuantity(quantity);
            foodOrderDto.setPrice(price * quantity);
            totalPrice += foodOrderRequestDto.getQuantity() * price;
            FoodOrder foodOrder = new FoodOrder(foodOrderDto);
            foodOrderRepository.save(foodOrder);
            foodOrders.add(foodOrder);
        }
        if(quantity < 1 || quantity >100) throw new IllegalArgumentException("주문 수량을 확인해주세요.");
        if(totalPrice < restaurantsRepository.findRestaurantsById(restaurantId).getMinOrderPrice()) throw new IllegalArgumentException("최소주문금액을 확인해주세요.");

        totalPrice += deliveryFee;
        OrderList orderList = new OrderList(restaurantName, foodOrders, deliveryFee, totalPrice);
        orderRepository.save(orderList);
        return orderList;

    }

    public List<OrderList> findOrders() {
        return orderRepository.findAll();
    }
}
