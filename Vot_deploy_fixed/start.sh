#!/bin/bash
javac -d out src/main/java/votingsystem/*.java
java -cp out votingsystem.VotingClient
