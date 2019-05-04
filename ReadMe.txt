WINDOWS
1)Download whole content of git Repository and put it in a new directory.
2) In Run.txt:
   1. set the path of your JDK if this one doesn't fit.
   2. save file as .bat file
3) run a new Run.bat file


ADDITIONAL ASSUMPTIONS:
1. User is allowed to choose a screening in a period of one week.
2. First of all, he needs to choose WHEN demo data should be placed (1-52 week of year 2019).
3. The most sensible way of testing the BookingApp is to select currently lasting week.
4. Choose a week NOT BEFORE currently lasting week - making reservations won't be possible otherwise.
5. The MULTIPLEX is a singleton which consists of 3 ScreeningRooms, weekly screenings Schedule and reservations hashmap.
5. Demo contains 4 movies. Each one is available every day. 
6. 6 screenings per day.
7. There are no demo reservations in the system which means that seats during each screening are free to sit. 
8. Entities such as Movie or ScreeningRoom are not that significant in the solution. They might be useful in case of expanding the application
