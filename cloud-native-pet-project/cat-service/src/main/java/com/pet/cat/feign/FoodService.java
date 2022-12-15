/**
 * 
 */
package com.pet.cat.feign;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Li Shu
 *
 */
@Service
public class FoodService {
	@Value("${pet-food.url}")
        private String url;

        public String getFood(String petType) {
                String content = "food details is not available for cats at the moment! try again later.";
                try {
                        RestTemplate client = new RestTemplate();
			String uri = url + "/food/pet/" + petType; 
			content =  client.getForObject(uri, String.class);
                } catch (Exception e) {
                        e.printStackTrace();
                }

                return content;
        }
}

