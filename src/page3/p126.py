from collections import defaultdict


def get_cuboid_layer_size(x, y, z, l):
    surface_area = 2*(x*y + y*z + x*z)
    perimeter = 4*(x + y + z)
    calculation = surface_area + l*perimeter + 4*l*(l-1)
    return calculation


counts = defaultdict(int)
N = 20000
width = 1
while True:
    length = width
    while True:
        height = length
        while True:
            layer = 0
            while True:
                calc = get_cuboid_layer_size(width, length, height, layer)
                if calc > N:
                    break
                counts[calc] += 1
                layer += 1
            height += 1
            layer = 0
            calc = get_cuboid_layer_size(width, length, height, layer)
            if calc > N:
                break
        length += 1
        height = length
        calc = get_cuboid_layer_size(width, length, height, layer)
        if calc > N:
            break
    width += 1
    length = width
    calc = get_cuboid_layer_size(width, length, height, layer)
    if calc > N:
        break

for calc in sorted(counts.keys()):
    # print(calc, counts[calc])
    if counts[calc] == 1000:
        print(calc)
        break
