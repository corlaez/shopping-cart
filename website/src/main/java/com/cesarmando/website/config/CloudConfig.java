package com.cesarmando.website.config;

import com.cesarmando.website.service.FileService;
import org.jclouds.ContextBuilder;
import org.jclouds.blobstore.BlobStore;
import org.jclouds.blobstore.BlobStoreContext;

/**
 * Created by jarma on 15/04/2017.
 */
public class CloudConfig {

    public BlobStore blobStoreB2() {
        BlobStore blobStore = ContextBuilder.newBuilder("b2")
                .credentials("00f351885d69", "00123f8403cccaaeb0a65b3fba7a33af4364636128")
                .buildView(BlobStoreContext.class)
                .getBlobStore();
        return blobStore;
    }

    public FileService fileService(BlobStore blobStore){
        return new FileService() {//shopfiles a0a0dff31531783855bd0619 backblaze.com
            @Override
            public void setProductFile(byte[] bytes) {

            }
        };
    }

}
