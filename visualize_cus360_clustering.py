
# coding: utf-8

# In[146]:


import numpy as np 
import matplotlib.pyplot as plt 
import matplotlib.patches as mpatches
import pandas as pd

colors  = np.random.rand(16,3)
attributes = [
				'T_TOT_CHARGE',
				'V_TIMES',
				'V_DURATION',
				'V_TOT_CHARGE',
				'V_INT_TIMES',
				'V_INT_DURATION',
				'V_INT_ORG_CHARGE',
				'V_EXT_TIMES',
				'V_EXT_DURATION',
				'V_EXT_ORG_CHARGE',
				'V_INTN_TIMES',
				'V_INTN_DURATION',
				'V_INTN_ORG_CHARGE',
				'V_TIMES_10S',
				'V_TIMES_30S',
				'V_TIMES_60S'
			]


# In[2]:


def visualize_centroids(centroids, K):
    centroids = np.array(centroids)
    fig, ax = plt.subplots()
    ind = np.arange(K)*10  # the x locations for the groups
    width = 0.35       # the width of the bars


    # draw
    for i in range(centroids.shape[1]):
        ax.bar(ind + i*width, centroids[:, i], width, color=colors[i, :])


    # add some text for labels, title and axes ticks
    ax.set_ylabel('x')
    ax.set_title('s')
    ax.set_xticks(ind + width / 2)
    ax.legend(attributes)


# In[25]:


def draw_elbow():
	plt.figure()
	cost = np.load('cost.npy')
	plt.plot(np.array(range(2, len(cost))), cost[2:])


# In[115]:


def visualize_line_centers(centers, describe_clusters,K):
    colors = np.random.rand(K, 3)
    plt.figure(figsize=(30,10))
    plt.xticks(range(len(attributes)), attributes)
    
    legends = [
        mpatches.Patch(
            color=colors[i],
            label='Cluster '+str(i)+' : '+str(int(describe_clusters[i][0][0]))
        ) for i in range(K)
    ]
    plt.legend(handles=legends)
    x = range(centers.shape[1])
    for i in range(K):
        plt.plot(x, centers[i], linewidth=8, color=colors[i])
        plt.scatter(x, centers[i], s=400, color=colors[i])
    


# In[155]:


def show_save_distance_table(centers):
    K = centers.shape[0]
    distances = np.zeros([K, K])
    for i in range(K):
        for j in range(K):
            distances[i][j] = np.linalg.norm(centers[i] - centers[j])
    # Save to .xlsx file
    clusters = ['cluster '+str(i) for i in range(K)]
    df = pd.DataFrame(distances, columns=clusters, index=clusters)
    df.to_excel('csv/distances.xlsx')
    print(df)


# In[177]:


def show_save_F_test(F_test):
    df = pd.DataFrame(F_test, columns=['F_test'], index=attributes)
    df = df.sort_values(by=['F_test'], ascending=False)
    df.to_excel('csv/F_test.xlsx')
    df.head()


# In[178]:


centers = np.load('centers.npy')
describe_clusters = np.load('describe_clusters.npy')
# visualize_line_centers(centers, describe_clusters, 5)
# draw_distance_table(centers)
# print(describe_clusters)
F_test = np.load('F_test.npy')
show_save_F_test(F_test)


# In[170]:


###########
plt.show()

