"use client";

import { useAppDispatch, useAppSelector } from "@/app/redux";
import { setIsSidebarCollapsed } from "@/state";
import { Box, IndianRupee, Layout, LucideIcon, Menu, NotebookText, Users, Warehouse } from "lucide-react";
import Link from "next/link";
import { usePathname } from "next/navigation";

interface SidebarLinkProps {
  href: string;
  icon: LucideIcon;
  lable: string;
  isCollapsed: boolean;
}

const SidebarLink = ({
  href,
  icon: Icon,
  lable,
  isCollapsed
}: SidebarLinkProps) => {
  const pathname = usePathname();
  const isActive = pathname === href || (pathname === "/" && href === "/dashboard");

  return(
    <Link href={href}>
      <div className={`cursor-pointer flex items-center 
        ${isCollapsed ? "justify-center py-4" : "justify-start px-8 py-4"} 
        hover:text-blue-500 hover:bg-blue-100 gap-3 transition-colors 
        ${isActive ? "bg-blue-200 text-white" : ""}`}>
          <Icon className="w-6 h-6 !text-gray-700" />

          <span className={`${isCollapsed ? "hidden" : "block"} font-medium text-gray-700`}>
            {lable}
          </span>
        </div>
    </Link>
  )
}

const Sidebar = () => {

  const dispatch = useAppDispatch();
  const isSidebarCollapsed = useAppSelector(
    (state) => state.global.isSidebarCollapsed
  );

  const toggleSidebar = () => {
    dispatch(setIsSidebarCollapsed(!isSidebarCollapsed));
  };

  const sidebarClassNames = `fixed flex flex-col 
    ${isSidebarCollapsed ? "w-0 md:w-16": "w-72 md:w-64"} bg-white transition-all duration-300 overflow-hidden h-full shadow-md z-40`;

  return (
    <div className={sidebarClassNames}>
      {/* Top */}
      <div className={`flex gap-3 justify-between md:justify-normal items-center pt-8 ${isSidebarCollapsed ? "px-5" : "px-8"}`}>
        <div>Logo</div>
        <h1 className={`${isSidebarCollapsed ? "hidden" : "block"} font-extrabold text-2xl`}>Autotriz</h1>
        <button
          className="md:hidden px-3 py-3 bg-gray-100 rounded-full hover:bg-blue-100"
          onClick={toggleSidebar}
        >
          <Menu className="w-4 h-4" />
        </button>
      </div>
      {/* Side bar Links */}
      <div className="flex-grow mt-8">

        <SidebarLink href="/dashboard" icon={Layout} lable="Dashboard" isCollapsed={isSidebarCollapsed} />

        <SidebarLink href="/bookings" icon={NotebookText} lable="Bookings" isCollapsed={isSidebarCollapsed} />

        <SidebarLink href="/accounting" icon={IndianRupee} lable="Accounting" isCollapsed={isSidebarCollapsed} />

        <SidebarLink href="/customers" icon={Users} lable="Customers" isCollapsed={isSidebarCollapsed} />

        <SidebarLink href="/inventory" icon={Box} lable="Inventory" isCollapsed={isSidebarCollapsed} />

        <SidebarLink href="/garage" icon={Warehouse} lable="Garage" isCollapsed={isSidebarCollapsed} />


      </div>

      {/* Footer */}
      <div className={`${isSidebarCollapsed ? "hidden" : "block"} mb-10`}>
        <p className="text-center text-xs text-gray-500">&copy; 2024 Maski</p>
      </div>

    </div>

  );
};

export default Sidebar;
