import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { }

  fetchJsonForVehicleMicroservice() {
    return this.http.get(`http://localhost:8080/vehicle/details`);
  }

  fetchJsonForBookMicroservice() {
    return this.http.get(`http://localhost:8080/book/all`);
  }

  fetchJsonForLocationMicroservice() {
    return this.http.get(`http://localhost:8080/location/distance`);
  }

  fetchJsonForCustomerMicroservice() {
    return this.http.get(`http://localhost:8080/customer/find`);
  }
}
