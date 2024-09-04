import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

export type Bookings = booking[];
export interface booking {
  bookingId: number | null;
  vehicle: number | null;
  service: number | null;
  employees: number[];
  start_date: Date | null;
  delivery_date: Date | null;
  bookingStatus: string | null;
  servicePrice: number | null;
  totalAmountDue: number | null;
  payments: number[];
}

export type Customers = Customer[];
export interface Customer {
    customerId: number | null;
    customerName: string;
    address: string;
    email: string;
    phoneNumber: number | null;
    vehicles: number[];
}

export type Payments = Payment[];
export interface Payment {
    paymentId: number | null;
    paymentDate: Date | null;
    paymentAmount: number | null;
    paymentMethod: string | null;
    paymentStatus: string | null;
    booking: number | null;
}

export type Employees = Employee[];
export interface Employee {
    employeeId: number | null;
    employeeName: string;
    address: string;
    email: string;
    phoneNumber: number | null;
    dateOfJoining: Date;
    bookings: number[];
}

export type Services = Service[];
export interface Service {
    serviceId: number | null;
    serviceName: string;
    serviceDescription: string;
    serviceDuration: number | null;
    bookings: number[];
}

export type Vehicles = Vehicle[];
export interface Vehicle {
    vehicleId: number | null;
    customer: number | null;
    make: string;
    model: string;
    vehiclePlateNumber: string;
    bookings: number[];
}


export const api = createApi({
  baseQuery: fetchBaseQuery({ baseUrl: process.env.NEXT_PUBLIC_API_BASE_URL }),
  reducerPath: "api",
  tagTypes: ["bookings","employees", "vehicles", "services", "customers", "payments"],
  endpoints: (build) => ({
    getBookings: build.query<Bookings, void>({
      query: () => "/bookings",
      providesTags: ["bookings"],
    }),
    getEmployees: build.query<Employees, void>({
      query: () => "/employees",
      providesTags: ["employees"],
    }),
    getVehicles: build.query<Vehicles, void>({
      query: () => "/vehicles",
      providesTags: ["vehicles"],
    }),
    getServices: build.query<Services, void>({
      query: () => "/services",
      providesTags: ["services"],
    }),
    getCustomers: build.query<Customers, void>({
      query: () => "/customers",
      providesTags: ["customers"],
    }),
    getPayments: build.query<Payments, void>({
      query: () => "/payments",
      providesTags: ["payments"],
    }),
  }),
});

export const {
    useGetBookingsQuery,
    useGetEmployeesQuery,
    useGetCustomersQuery,
    useGetServicesQuery,
    useGetVehiclesQuery,
    useGetPaymentsQuery
} = api;
