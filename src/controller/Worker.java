package controller;

import model.Customer;
import model.Parcel;
import model.ParcelMap;
import model.QueueofCustomers;

public class Worker {

	private QueueofCustomers queue;
	private ParcelMap parcels;
	
	
	public Worker(QueueofCustomers queue , ParcelMap parcels) {
		this.queue = queue;
		this.parcels = parcels;
	}  
	
	public double calculateFee(Customer customer) {
		double totalFee = 0;
		for(String parcelId : customer.getParcelIds() ) {
			
			Parcel parcel = parcels.getParcelById(parcelId);
			if(parcel != null) {
				totalFee += parcel.getWeight()*10;
				
			}
		}
		return totalFee; 
		
	}
	
	public void processNextCustomer() {
		if (!queue.isEmpty()) {
			Customer customer = queue.dequeue();
			
			System.out.println("Processing customer:" + customer.getName());
		}
			
			
	}
}