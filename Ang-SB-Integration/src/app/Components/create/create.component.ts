import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Customer } from 'src/app/EntityClasses/customer';
import { CustomerService } from 'src/app/Services/customer.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent {

  customer: Customer = new Customer(0, '', ''); // Assuming the Customer class has a constructor with three parameters: id, name, email
  msg: string = '';
  emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  customerForm: any;


  constructor(private service: CustomerService) { }

  //@ViewChild('register', { static: true }) register!: NgForm;

  createCustomer(form: NgForm) {


    if (form.valid) {

      this.service.createCustomer(this.customer).subscribe({
        //next is callback function name  that handles the emitted values from the observable.
        next: (data) => {

          this.msg = data;
          console.log(this.customer);
          this.msg = 'Customer created successfully.';
          this.customer = new Customer(0, '', '');
          console.log('Customer created successfully.');
          form.resetForm();
        },

        error: (error) => {
          this.msg = 'Error occurred while saving customer data.';
          console.error(error);
        }
      });
    } else {
      // Form is invalid, display an error message or handle validation
      this.msg = 'Please fill in all required fields and fix any validation errors.';
    }
  }
}

//----------------------------------------------------------------------------------

// observable.subscribe({
//   next: (data) => {
//     // Handle emitted values
//   },
//   error: (error) => {
//     // Handle error
//     console.error(error);
//   },
//   complete: () => {
//     // Handle completion
//   }
// });


//----------------------------------------------------------

  // createCustomer() {
  //   this.service.createCustomer(this.customer).subscribe(
  //     (data) => {
  //       // Handle successful response
  //       this.customer = new Customer(0, '', '');
  //       console.log('Customer created successfully.');
  //     },
  //     (error) => {
  //       // Handle error response
  //       this.msg = 'Error occurred while saving customer data.';
  //       console.error(error);
  //     }
  //   );
  // }
