package com.example.FoodApplication.Service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import com.example.FoodApplication.ExceptionHandle.IdNotFoundException;
import com.example.FoodApplication.dao.CustomerDAO;
import com.example.FoodApplication.dao.FoodOrderDAO;
import com.example.FoodApplication.dao.ItemsDAO;
import com.example.FoodApplication.dto.Customer;
import com.example.FoodApplication.dto.FoodOrder;


@Service
public class CustomerService {

	@Autowired
	CustomerDAO customerDAO;

	@Autowired
	FoodOrderDAO foodOrderDAO;

	@Autowired
	ItemsDAO itemsDAO;

	@Autowired
	JavaMailSender javaMailSender;
	

	public Customer saveCustomer(Customer customer, int id) {
		customer.setGst(0.15);
		customer.setServiceCost(0.08);
		Optional<FoodOrder> order = foodOrderDAO.getFoodOrderById(id);
		if (order.isEmpty()) {
			throw new IdNotFoundException();
		} else {
			double total = order.get().getTotalPrize();
			customer.setT_cost(total + customer.getGst() + (total * customer.getServiceCost()));
			return customerDAO.saveCustomer(customer);
		}
	}

	public String sendMessage(Customer customer, int id) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		Optional<FoodOrder> order = foodOrderDAO.getFoodOrderById(id);

		if (order.isEmpty()) {
			throw new IdNotFoundException();
		} else {
			customer.setGst(0.15);
			customer.setServiceCost(0.08);
			double total = order.get().getTotalPrize();
			customer.setT_cost(total + customer.getGst() + (total * customer.getServiceCost()));
			simpleMailMessage.setFrom("shubhamgupta5026@gmail.com");
			simpleMailMessage.setTo(customer.getEmail());
			simpleMailMessage.setSubject("Bill");
			simpleMailMessage.setText("Your Food Order is " + order.get().getId() + "  and Your Food Price is " + total);
			javaMailSender.send(simpleMailMessage);

			String message = simpleMailMessage.getText();
			return message;
		}

	}
	
	

}
