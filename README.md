# Warring-Neighbours-
JAva program using SAFETY PROPERTY
Modeled the below scenario using Safety Property in java
Two warring neighbors are separated by a field with wild berries. They agree to permit each other to enter the field to pick berries, but also need to ensure that only one of them is ever in the field at a time. After negotiation, they agree to the following protocol.
When one neighbor wants to enter the field, he raises a flag. If he sees his neighbor’s flag, he does not enter but lowers his flag and tries again. If he does not see his neighbor’s flag, he enters the field and picks berries. He lowers his flag after leaving the field.
Model this algorithm for two neighbors, n1 and n2. Specify the required safety property for the field and check that it does indeed ensure mutually exclusive access. Specify the required progress properties for the neighbors such that they both get to pick berries given a fair scheduling strategy. Are there any adverse circumstances in which neighbors would not make progress? What if the neighbors are greedy?
