package org.booking.controllers;

import org.booking.beans.User;

import java.util.Scanner;


public class MainController {

    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        UserController userController = new UserController();
        HotelController hotelController = new HotelController();
        RoomController roomController = new RoomController();
        BookingController bookingController = new BookingController();
        User currUser;
        while(true)
        {
            System.out.println("1.Login   2.SignUp  3.Exit");
            int choice = sc.nextInt();
            if(choice == 2)
            {
                currUser = userController.getInput();
                if(currUser == null) System.out.println("Sign in failed");
                else
                {

                    userController.addUser(currUser);
                    System.out.println("Sign in Successful");
                    continue;
                }

            }

            else if(choice == 1)
            {
                currUser = userController.loginUser();
                if(currUser == null){
                    System.out.println("Login Failed. Please verify credentials or If you are first time user please Sign Up");
                    continue;
                }
                System.out.println("Login Successful");
                int userChoice=10;
                while(userChoice !=5) {
                    System.out.println(" 1. List All the Hotels \n 2. View All the Rooms in Hotel \n 3. Book A Room \n 4. Booking History \n 5. Logout");
                    userChoice = sc.nextInt();
                    if (userChoice == 1) {
                        System.out.println("List of Hotels");
                        if (hotelController.getAllHotels().isEmpty()) {
                            System.out.println("Hotels unavailable");
                            continue;
                        }
                        System.out.println(hotelController.getAllHotels());
                    } else if (userChoice == 2) {
                        System.out.println("Enter the Hotel Name :");
                        sc.nextLine();
                        String hotelName = sc.nextLine();
                        System.out.println("Room Details :");
                        String rooms = roomController.getRoomDetailsOfHotel(hotelName);
                        if (rooms.isEmpty()) {
                            System.out.println("Hotel is not available.");
                            continue;
                        }
                        System.out.println(rooms);
                    } else if (userChoice == 3) {
                        System.out.println("Enter the Room Number");
                        sc.nextLine();
                        String roomNo = sc.nextLine();
                        System.out.println("Enter Hotel Name");
                        String hotel = sc.nextLine();
                        System.out.println("Enter the Date in Format [DD:MM:YYYY]");
                        String date = sc.nextLine();
                        boolean available = bookingController.roomStatus(roomNo, hotel, date);
                        if (!available) {
                            System.out.println("Room is already booked");
                            continue;
                        } else {
                            System.out.println("Are you willing to book the Room ? Yes or No");
                            String confirm = sc.nextLine();
                            if(confirm.equals("No"))
                            {
                                System.out.println("Booking cancelled !");
                            }
                            else {
                                bookingController.bookRoom(currUser.getName(),hotel,roomNo,date);
                            }
                        }
                    }

                    else if(userChoice == 4)
                    {
                        String bookings = bookingController.viewBookings(currUser.getName());
                        if(bookings.isEmpty()) System.out.println("No Bookings :(");
                        else System.out.println("Your Bookings \n" + bookings);
                    }

                    else break;

                }

            }

            else break;
        }
    }
}
