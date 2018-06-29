
# coding: utf-8

# In[ ]:


# Import libraries necessary for this project
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.cluster import KMeans


# In[ ]:


# Initial
K = 3
labels = ['Fresh', 'Milk', 'Grocery', 'Frozen', 'Detergents_Paper', 'Delicassen']
colors = np.random.rand(len(labels), 3)


# In[ ]:


# Load the wholesale customers dataset
try:
    data = pd.read_csv("Wholesale customers data.csv")
    data.drop(['Region', 'Channel'], axis = 1, inplace = True)
    print ("Wholesale customers dataset has {} samples with {} features each.".format(*data.shape))
except:
    print ("Dataset could not be loaded. Is the dataset missing?")


# In[ ]:


# Display a description of the dataset
stats = data.describe()
print(stats)


# In[ ]:


# Process data
# ....
data = data.values

fresh = 60000
milk = 35000
grocery = 40000
frozen = 20000
detergents = 20000
delicassen = 20000

checker = (data[:, 0] < fresh) *    (data[:, 1] < milk) *    (data[:, 2] < grocery) *    (data[:, 3] < frozen) *    (data[:, 4] < detergents) *    (data[:, 5] < delicassen)

data = data[checker]


# In[ ]:


# Clustering
clusterer = KMeans(n_clusters=K).fit(data)

# TODO: Predict the cluster for each data point
preds = clusterer.predict(data)

# TODO: Find the cluster centers
centers = clusterer.cluster_centers_

print(centers)


# In[ ]:


def visualize_centroids(data, clusters, centroids, K):
    centroids = np.array(centroids)
    fig, ax = plt.subplots()
    ind = np.arange(K)*3  # the x locations for the groups
    width = 0.35       # the width of the bars

    # compute standard deviation of features
    std = []
    for i in range(K):
        std.append( np.std(data[clusters[i]], axis = 0) )
    std = np.array(std)
        
    # draw
    for i in range(centroids.shape[1]):
        ax.bar(ind + i*width, centroids[:, i], width, color=colors[i, :], yerr=std[:, i])


    # add some text for labels, title and axes ticks
    ax.set_ylabel('Scores')
    ax.set_title('Scores by group and gender')
    ax.set_xticks(ind + width / 2)
    ax.set_xticklabels(['cluster ' + str(i) for i in range(K)])
    ax.legend(labels)


# In[ ]:


def visualize_density(data, index):
    data = np.array(data)
    plt.figure()
    plt.suptitle('cluster ' + str(index) + ', ' + str(data.shape[0]))
    for i in range(data.shape[1]):
        plt.subplot(2, 3, i + 1)
        plt.hist(x =data[:, i], bins=20, color=colors[i, :])

visualize_density(data, 'x')


# In[ ]:


def draw_elbow(data):
    elb = {}
    for i in range(1, 10):
        clusterer = KMeans(n_clusters=i).fit(data)
        elb[i] = clusterer.inertia_
    plt.figure()
    plt.plot(list(elb.keys()), list(elb.values()))

draw_elbow(data)


# In[ ]:


# Visualize centroids
clusters = [np.where(clusterer.labels_ == i)[0] for i in range(clusterer.n_clusters)]

visualize_centroids(data, clusters, centers, K)

# Visualize density of features
for i in range(K):
    visualize_density(data[clusters[i]], i)

plt.show()

