# [Levenshtein Distance]([https://www.google.com](https://www.baeldung.com/java-levenshtein-distance#:~:text=The%20Levenshtein%20distance%20is%20a,Deletion%20of%20a%20character%20c))
 
The Levenshtein distance is a measure of dissimilarity between two Strings. A small part of this project is implemented using Levenshtein Distance Algorithm. Since one of the contraints is: "A word is considered “similar” to another word if the Levenshtein distance is not more than 1."

# Specifications

# User Story
- A researcher can view the frequency of a given word and any similar words in my lab notebook entry.

# Requirements 

- Determine frequency of word occurrence in notebook Entry
- Determine similar words in notebook Entry

# Sample Scenarios

- Given a basic notebook entry with the text “Word Words Wor word"
When the frequency of the word “Word” is requested
Then the frequency is determined to be `1`
And the list of similar words is determined to be “Words", "Wor", "word"

- Given a basic notebook entry with the text “Word Word Word word"
When the frequency of the word “Word” is requested
Then the frequency is determined to be `3`
And the list of similar words is determined to be “word"

# Project 

You should be able to start the example application by executing com.levenshteinDistance.LevenshteinDistanceApplication, which starts a webserver on port 8080 (http://localhost:8080). [Frontend side](https://github.com/kamuranunsal/search-react-app) of this project is implemented in Typescript using React.

The project is based on a small web service which uses the following technologies:

- Java 17

- Spring Boot

- Database H2 (In-Memory)

- Maven

The architecture of the web service is built with the following components:

DataTransferObjects: Objects which are used for outside communication via the API
Controller: Implements the processing logic of the web service, parsing of parameters and validation of in- and outputs.
Service: Implements the business logic and handles the access to the DataAccessObjects.
DataAccessObjects: Interface for the database. Inserts, updates, deletes and reads objects from the database.
DomainObjects: Functional Objects which might be persisted in the database

# New Features

- A researcher can import different type of files and search on that files.
- Database can be transformed to Mongo DB
- Full text search can be implemented 
- Most recent searched texts can be logged or stored in clusters and data indexers can search on these clusters and return results quickly
