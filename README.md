# MVVMWithFlows

This Android application displays list of names with the first letter capitalized.

This project is built on MVVM Architecture and uses two different types of data sources which save the names in all lower case. 

The repository class fetches the names from the local data source (database), if no local data is available, then a call is made to the remote data source to get the required data. The data fetched from remote source is saved in the local data source for future use.

Kotlin Flows are used to observe the change in value of data objects and the changes will be reflected on the UI automatically using Live Data.

We are using an in-built function to convert the lower case names into first letter capitalized for each word. For example: 

    f(“elon musk”) = “Elon Musk”

We are also using dependency injection to get the instance of App database and DAOs in our local data source.

Input json: https://github.com/akhilmatura11/MVVMWithFlow/blob/master/app/src/main/assets/names.json

![MVVMWithFlows](https://user-images.githubusercontent.com/94434188/168579386-ba7b4819-9bd8-4648-8fc3-7db761e5344f.png)


**Additional question:**

**Q. Which technologies would you use for implementing the remote & local data source in a real application, assumed our backend provides a REST API**

A. For REST API backend, it’s safe to use retrofit for implementing the remote data sources. We can use the library “com.squareup.retrofit2:converter-moshi:2.9.0“ which has an inbuilt Moshi convertor which will automatically convert the JSON response into data models to be used by the android application.

Along with retrofit remote data source we will use Room database for local data source. 

