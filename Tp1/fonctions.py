def puissance (a, b) : 
	if not type(a) is int:
		raise TypeError("Only integers are allowed")
	if not type(b) is int:
		raise TypeError("Only integers are allowed")
	
	i=0
	puissance = a
	for i in range (1,b):
		puissance=puissance*a
		i=i+1
	return (puissance)
	

