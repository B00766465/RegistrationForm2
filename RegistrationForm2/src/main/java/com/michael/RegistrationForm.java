package com.michael;

import com.vaadin.data.Binder;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;

public class RegistrationForm<T extends User> extends VerticalLayout {

    private static final long serialVersionUID = 1L;
    private TextField userEmail;
    private TextField userPassword;
    private TextField confirmPassword;
    private TextField customerName;
    private TextField contactName;
    private TextField address1;
    private TextField address2;
    private TextField address3;
    private TextField phone;

    private T user;
    Binder<T> binder = new Binder<>();

    public RegistrationForm() {
 
        //Add the components of the form (Textfields)
        userEmail = new TextField("User Email:");
        userPassword = new TextField("User password:");
        confirmPassword= new TextField("Confirm Password:");
        customerName= new TextField("Customer Name:");
        contactName = new TextField("Contact Name:");
        address1 = new TextField("Address Line 1:");
        address2 = new TextField("Address Line 2:");
        address3 = new TextField("Address Line 3:");
        phone = new TextField("Phone Number:");
       
  
        //Add the labels, buttons and listeners
        Label registeredLabel = new Label("<strong>Click Register Me to register</strong>", ContentMode.HTML);
        Button registerButton = new Button("Register Me");
        registerButton.addClickListener(e -> {
			//Changedfromhere
			if(userEmail.getValue().length()==0)
			{
				registeredLabel.setValue("<h3><strong> Enter an email address </strong></h3>");
				return;
			}//End if userEmail
			if(userPassword.getValue().length()==0)
			{
				registeredLabel.setValue("<h3><strong> Enter a user password </strong></h3>");
				return;
			}//End if userPassword
			if(confirmPassword.getValue().length()==0)
			{
				registeredLabel.setValue("<h3><strong> Please confirm your password </strong></h3>");
				return;
            }//End if confirmPassword
            if(!confirmPassword.getValue().equals(userPassword.getValue()))
			{
				registeredLabel.setValue("<h3><strong> Confirmed password not the same as password please correct </strong></h3>");
				return;
            }//End if check confirmPassword does not equal password
           
			if(customerName.getValue().length()==0)
			{
				registeredLabel.setValue("<h3><strong> Please enter a customerName </strong></h3>");
				return;
			}//End if customerName
			if(contactName.getValue().length()==0)
			{
				registeredLabel.setValue("<h3><strong> Please enter a contact name </strong></h3>");
				return;
			}//End if contactName
			if(address1.getValue().length()==0)
			{
				registeredLabel.setValue("<h3><strong> Please enter address1 </strong></h3>");
				return;
			}//End if address1
			if(address2.getValue().length()==0)
			{
				registeredLabel.setValue("<h3><strong> Please enter address2 </strong></h3>");
				return;
			}//End if address2
			if(address3.getValue().length()==0)
			{
				registeredLabel.setValue("<h3><strong> Please enter address3 </strong></h3>");
				return;
			}//End if address3
			if(phone.getValue().length()==0)
			{
				registeredLabel.setValue("<h3><strong> Please enter your phone number </strong></h3>");
				return;
			}//End if phone
			
			//EndChanges
            registeredLabel.setValue("<h3><strong> You have been registered </strong></h3>");
            return;
        });
        
        Label cancelLabel = new Label("<strong>Click Cancel to cancel your registration</strong>", ContentMode.HTML);
        Button cancelButton = new Button("Cancel");
        cancelButton.addClickListener(e -> {
            cancelLabel.setValue("<h3><strong> Your registration is cancelled!</strong></h3>");
        });

        //Layouts
        HorizontalLayout hLayout = new HorizontalLayout();
        HorizontalLayout hLayout2 = new HorizontalLayout();
        hLayout.addComponents(registerButton, registeredLabel, cancelButton, cancelLabel);
        hLayout2.addComponents(userEmail, userPassword, confirmPassword);
        addComponents(hLayout2, customerName, contactName,address1, address2, address3, phone, hLayout);
        
    }

    //setUser
    public void setUser(T user) {
        this.user = user;
        this.binder.setBean(this.user);
    }//setUser

}//Class
