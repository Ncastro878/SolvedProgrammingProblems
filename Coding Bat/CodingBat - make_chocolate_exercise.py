def make_chocolate(small, big, goal):
  '''
    code from successful CodingBat exercise called Make Chocolate. First successful one
    Python
  '''

  Able = False  
  num_big = 0
  num_small = 0
  
  #Test if even capABLE of making goal,
  #if yes, set Able var to True & make note of how many
  #big bars needed via num_big variable
  for i in range(big+1):
    if goal >= ((i*5)) and goal <= ((i*5)+small):
      Able = True
      num_big = i
  
  #if not able to make goal, then quit and return -1
  if Able == False:
    return -1
   
  '''Now we test range of our needed big bars amount by adding all
    the small bars 1 by 1 until we hit out Goal.
    Once goal is hit, we make note of how many small
    bars needed via the num_small variable then break
    out of the loop
  '''
  for i in range(small + 1):
    if i + (num_big*5) == goal:
      num_small = i
      break
  
  #return the num_small var noted from before
  return num_small
