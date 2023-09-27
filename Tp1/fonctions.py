def puissance (a, b) : 
	if not type(a) is int:
		raise TypeError("Only integers are allowed")
	if not type(b) is int:
		raise TypeError("Only integers are allowed")
	
	i=0
	puissance = a
	
	if b==0 : 
		puissance =1
	
	elif a==0 and b<0 :
		raise TypeError("Only not supported")
	
	elif b<0 :
		puissance=1/a**-b
		
	else : 
		for i in range (1,b):
			puissance=puissance*a
			i=i+1
	return (puissance)
	

