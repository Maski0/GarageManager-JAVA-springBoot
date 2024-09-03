import { useGetBookingsQuery } from "@/state/api";
import React from "react";

const CardRecentBookings = () => {
  const { data: bookings, error, isLoading } = useGetBookingsQuery();

  return (
    <div className="row-span-3 xl:row-span-6 bg-white shadow-md rounded-2xl pb-16 overflow-x-auto">
      {isLoading ? (
        <div className="m-5">Loading...</div>
        
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
              {bookings?.map((booking) => (
                <tr>
                  <td className="py-2 px-4">{booking.vehicle}</td>
                  <td className="py-2 px-4">
                    {booking.delivery_date ? new Date(booking.delivery_date).toLocaleDateString('en-US') : 'Invalid date'}
                  </td>
                  <td className="py-2 px-4">
                    {booking.service}
                  </td>
                  <td className="py-2 px-4">
                    {booking.employees.map((employee) => (
                      <button className="px-4 py-2 rounded hover:bg-gray-500">
                        {employee}
                      </button>
                    ))}
                  </td>
                  <td className="py-2 px-4">
                    {/* Will have to convert to a dynamic mapping of chaning*/}
                    <span className="inline-block p-1 rounded bg-emerald-500/10 text-emerald-500 font-semibold text-[12px]">{booking.bookingStatus}</span>
                    <svg className="animate-spin h-5 w-5 mr-3" viewBox="0 0 24 24"></svg>
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
