import { useGetBookingsQuery, useGetEmployeesQuery, useGetServicesQuery, useGetVehiclesQuery } from "@/state/api";
import { ChevronRight, CircleEllipsis, Loader2 } from "lucide-react";
import React from "react";

const CardRecentBookings = () => {
  const {
    data: bookings,
    error: bookingsError,
    isLoading: getBookingsisLoading,
  } = useGetBookingsQuery();
  const {
    data: employees,
    error: employeesError,
    isLoading: getEmployeesisLoading,
  } = useGetEmployeesQuery();
  const {
    data: vehicles,
    error: vehiclesError,
    isLoading: getvehiclesisLoading,
  } = useGetVehiclesQuery();
  const {
    data: services,
    error: servicesError,
    isLoading: getservicesisLoading,
  } = useGetServicesQuery();

  return (
    <div
      className={`row-span-3 xl:row-span-6 bg-white shadow-md rounded-2xl pb-16 overflow-x-auto ${
        getBookingsisLoading ? "flex justify-center items-center" : ""
      }`}
    >
      {getBookingsisLoading ? (
        <Loader2 className="animate-spin"></Loader2>
      ) : (
        <>
          <h3 className="text-lg font-semibold px-7 pt-5 pb-2">
            Recent Bookings
          </h3>
          <table className="w-full table-auto">
            <thead className="border-b-2 border-gray-200 uppercase ">
              <tr>
                <th className="tracking-wide font-medium text-gray-400 py-2 px-4 text-left rounded-tl-md rounded-bl-md">
                  Vehicle
                </th>
                <th className="tracking-wide font-medium text-gray-400 py-2 px-2 text-left">
                  DeliveryDate
                </th>
                <th className="tracking-wide font-medium text-gray-400 py-2 px-4 text-left">
                  Service
                </th>
                <th className="tracking-wide font-medium text-gray-400 py-2 px-4 text-left">
                  Employess
                </th>
                <th className="tracking-wide font-medium text-gray-400 py-2 px-4 text-left rounded-tr-md rounded-br-md">
                  Status
                </th>
              </tr>
            </thead>
            <tbody>
              {bookings?.map((booking, index) => (
                <tr key={booking.bookingId} className={`${index % 2 ? "bg-gray-100" : ""}`}>
                  <td className="py-2 px-4">
                    {(() => {
                      const currentVehicle = vehicles?.find((veh) => veh.vehicleId === booking.vehicle);
                      return(
                        <div>
                          <p className="font-semibold text-base">{currentVehicle?.vehiclePlateNumber}</p>
                          <p >
                            <a className="font-bold">{currentVehicle?.make}</a> {currentVehicle?.model}
                          </p>
                        </div>
                      );
                    })()}
                  </td>
                  <td className="py-2 px-4">
                    {booking.delivery_date
                      ? new Date(booking.delivery_date).toLocaleDateString(
                          "en-US"
                        )
                      : "Invalid date"}
                  </td>
                  <td className="py-2 px-4">
                    {(() => {
                      const currentService = services?.find((ser) => ser.serviceId === booking.service);
                      return(
                        <div>
                          {currentService?.serviceName}
                        </div>
                      );
                    })()}
                  </td>
                  <td className="py-2 px-4 flex flex-col space-y-2">
                    {booking.employees.map((employee) => {
                      const Currentemployee = employees?.find(
                        (emp) => emp.employeeId === employee
                      );
                      return (
                        <button
                          className="px-4 py-2 rounded hover:bg-blue-100 shadow-md bg-gray-200"
                          key={employee}
                        >
                          {Currentemployee ? Currentemployee.employeeName : `Unknown Id:${employee}`}
                        </button>
                      );
                    })}
                  </td>
                  <td className="py-2 pl-4">
                    {/* Will have to convert to a dynamic mapping of chaning*/}
                    <span className="inline-block p-1 rounded bg-emerald-500/10 text-emerald-500 font-semibold text-[12px]">
                      {booking.bookingStatus}
                    </span>
                    <svg
                      className="animate-spin h-5 w-5 mr-3"
                      viewBox="0 0 24 24"
                    ></svg>
                  </td>
                  <td className="py-2">
                    <button className="px-3 py-3 rounded-full hover:bg-blue-100 flex items-center justify-center">
                      <ChevronRight className="w-5 h-5"/>
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </>
      )}
    </div>
  );
};

export default CardRecentBookings;
