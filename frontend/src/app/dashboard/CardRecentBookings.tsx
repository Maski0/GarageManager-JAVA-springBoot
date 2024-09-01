import React from "react";

const CardRecentBookings = () => {
    
    const isLoading = false;
    return (
        <div className="row-span-3 xl:row-span-6 bg-white shadow-md rounded-2xl pb-16"> 
            {isLoading ? (
                <div className="m-5">Loading...</div>
            ) : (
                <>
                    <h3 className="text-lg font-semibold px-7 pt-5 pb-2">
                        Recent Bookings
                    </h3>
                </>
            )} 
        </div>
    )
}

export default CardRecentBookings;