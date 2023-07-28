# coffee-order-android
https://github.com/landoulsi/coffee-order-android

## Overview
This application consist on Coffee ordering app, which you can think that is developed by a restaurant owner who just learned 
programming and wanted to install this app on a tablet to facilitate ordering coffee to his clients
It consists on 2 Activities `OrderListActivity` and `AddOrderActivity` 

`OrderListActivity` is the start activity (launcher Activity), it contains:
- List of orders
- Button to clear the list
- Button to refresh the list
- Button to open `AddOrderActivity`

`AddOrderActivity` is the screen (Activity) that we will be represneted to clients and we will mainly work on it on the first half hour
As said, this is a very low quality code and you as a developer try to improve the code for better quality and scalability

This screen contains only 3 input from the client
- Client name
- Coffee type (Cappuccino / Espresso / Regular) -> represented by a row of toggle buttons (only one is selected at a time)
- Coffee cup size (Small / Medium / Large) -> represented by a row of toggle buttons (only one is selected at a time)

Each Coffee Type has a base price: Cappuccino (6$), Espresso (5$), Regular (4$)
Each Cup Size has a factor multiplier (Small -> 0, Medium -> 1, Large -> 2) that will be used to calculate total price

Total price of the order depend on only 2 things: Coffee Type and Coffee Cup Size, using this unique formula:
`Total price = basePrice + (basePrice * 0.25 * size)` 
where `basePrice` is the base Coffee Type price as descibed above
`0.25` is constant factor
`size` is a `factor multiplier` for the Cup Size

## Important points to focus on, on the first 30 min of the interview:
- The code is working fine and we just try to improve the quality of it keeping same functionalities
- For the sake of time, you will only work on the same activity, trying to improve the code on the same class first
- Try to find how you can make the code more readable so anyone can understand and maintain it very easily
- Try to reduce duplicated code for the toggle buttons, selection logic
- Create the method that will calculate the total price based on the formula described above
- Try to find code, variables or constants that are not in the right place
- Try to find missing code encapsulations
- Explain how you can make the code more testable

## Bonus
- It will much valudable if after all the improvements you done above, the code is still compiling and giving same result
