package kr.co.motiveko.eatgo.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.motiveko.eatgo.domain.MenuItem;
import kr.co.motiveko.eatgo.domain.MenuItemRepository;
import kr.co.motiveko.eatgo.domain.Restaurant;
import kr.co.motiveko.eatgo.domain.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	MenuItemRepository menuItemReposiory;
	
	public RestaurantService(RestaurantRepository restaurantRepository, 
								MenuItemRepository menuItemReposiory) {
		this.restaurantRepository = restaurantRepository;
		this.menuItemReposiory = menuItemReposiory;
	}

	public Restaurant getRestaurant(Long id) {
		Restaurant restaurant = restaurantRepository.findById(id);
		List<MenuItem> menuItems = menuItemReposiory.findAllByRestaurantId(id);
		restaurant.setMenuItems(menuItems);		
		
		return restaurant;
	}

	public List<Restaurant> getRestaurants() {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		return restaurants;
	}
	
}