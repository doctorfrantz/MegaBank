# MegaBank

MegaBank is a banking app with some basic functionalities such as managing money transferences between accounts and checking their balances.


<h2>Admin</h2>

Admins have the ability to create and delete accounts and change accounts balances.


<h2>Third Party</h2>

Third parties are external users that are not part of the bank, but that are able to perform transactions with other accounts.


<h2>Account Holders</h2>

Account holders are individuals who are associated with the banking institution and have one or more accounts with it. They can perform transactions, earn interest, and utilize other account-related features available in the API. However, they are only authorized to access the accounts and corresponding functionalities that they possess.


<h1>Accounts</h1>


There are various kinds of Accounts, all of which share the characteristics of the Abstract Account class. These features include:

- An automatically generated ID, which helps to sort and find accounts in the database.
- A balance represented as a BigDecimal.
- A primary owner, who is an Account Holder.
- An optional SecondaryOwner, which may or may not be present.
- A penalty fee of 40€, which is applied when an account's balance falls below its minimum balance.
- A creation date.
- A Status, which can be FROZEN or ACTIVE.

In addition to the parameters outlined in the parent class, there are several child classes, each with their own unique set of parameters.

- <h4>Checking Accounts</h4>
- <h4>Student Checking Account</h4>
- <h4>Savings Account</h4>
- <h4>Credit Card</h4>

<h1>Functions</h1>


<h5>GET route:</h5>
- /accountsByUserId/{Id}

<h5>PATCH route:</h5>
- /tranfer/{id}

<h5>POST route:</h5>
- /create/{accountType}/{id}



