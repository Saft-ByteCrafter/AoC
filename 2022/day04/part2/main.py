file = open("input")
file_contents = file.readlines()
file.close()

score = 0

for line in file_contents:
    line = line.split(",")
    a = line[0].split("-")
    b = line[1].split("-")
    b[1] = b[1].strip("\n")
    a[0] = int(a[0])
    a[1] = int(a[1])
    b[0] = int(b[0])
    b[1] = int(b[1])
    if (a[0] <= b[1] and a[0] >= b[0]) or (a[1] <= b[1] and a[1] >= b[0]) or (a[0] <= b[0] and a[1] >= b[1]):
        score += 1

print(score)
