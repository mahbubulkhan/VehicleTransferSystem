package com.bharaththippireddy.trainings.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




import com.bharaththippireddy.trainings.jaxrs.Patient;

public class PatientServiceClient {

	private static final String PATIENT_SERVICE_URL = "http://localhost:8080/restws/services/patientservice";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target(PATIENT_SERVICE_URL).path("/patients").path("/{id}").resolveTemplate("id", 123);
		Patient patient = target.request().get(Patient.class);
		/*Response response = target.request().get();
		System.out.println(response.getStatus());*/
		System.out.println(patient.getName());
		
		WebTarget putTarget = client
		.target(PATIENT_SERVICE_URL).path("/patients");
		patient.setName("Bharat");
		Response updatedResponse = putTarget.request().put(Entity.entity(patient, MediaType.APPLICATION_XML));
		System.out.println(updatedResponse.getStatus());
		updatedResponse.close();
		
		Patient newPatient = new Patient();
		newPatient.setName("Thippireddy");
		
		WebTarget postTarget = client
				.target(PATIENT_SERVICE_URL).path("/patients");
		Patient postResponse = postTarget.request().post(Entity.entity(patient, MediaType.APPLICATION_XML), Patient.class);
		System.out.println(postResponse.getId()+" "+postResponse.getName());
		
	WebTarget deleteTarget = client
				.target(PATIENT_SERVICE_URL).path("/patients").path("/{id}").resolveTemplate("id", 124);
	//Patient delPatient= deleteTarget.request().delete(Patient.class);
	deleteTarget.request().delete(Patient.class);
	
		client.close();
	}

}
