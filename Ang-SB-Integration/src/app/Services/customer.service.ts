import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../EntityClasses/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  //  baseUrl = 'http://localhost:9090';

  baseUrl: string = 'http://localhost:9090';

  constructor(private http: HttpClient) { }

  getAllCustomer(): Observable<Customer[]> {

    return this.http.get<Customer[]>(`${this.baseUrl}/all`);
  }

  deleteCustomer(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/customer/delete/${id}`, { responseType: 'text' });
  }

  createCustomer(customer: Customer): Observable<any> {
    return this.http.post(`${this.baseUrl}/customer/save`, customer, { responseType: 'text' });
  }

  getCustomerById(id: number): Observable<Customer> {
    return this.http.get<Customer>(`${this.baseUrl}/customer/${id}`);
  }

  updateCustomer(id: number, customer: Customer): Observable<any> {
    return this.http.put(`${this.baseUrl}/customer/edit/${id}`, customer, {
      responseType: 'text',
    });
  }

}
