/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */

package com.example.data_12_21.mapapi.clusterutil.clustering;


import com.baidu.mapapi.model.LatLng;

import java.util.Collection;

/**
 * A collection of ClusterItems that are nearby each other.
 */
public interface Cluster<T extends com.example.data_12_21.mapapi.clusterutil.clustering.ClusterItem> {
    public LatLng getPosition();

    Collection<T> getItems();

    int getSize();
}