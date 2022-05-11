import networkx as nx

G = nx.Graph()
with open("../../resources/p107_network.txt") as text_file:
# with open("../../resources/test.txt") as text_file:
    for i, line in enumerate(text_file):
        edge_weights = line.rstrip().split(",")
        for j in range(i+1, 40):
            w = edge_weights[j]
            if w == '-':
                continue
            w = int(w)

            G.add_edge(i, j, weight=w)

total_weight = G.size(weight='weight')
min_weight = nx.minimum_spanning_tree(G).size(weight='weight')

print(total_weight - min_weight)

