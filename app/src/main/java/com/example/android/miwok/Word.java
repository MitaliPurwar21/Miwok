package com.example.android.miwok;

import android.content.pm.InstrumentationInfo;

/**
 * Created by Dell on 17-03-2017.
 */

public class Word {

    //Default Translation for word
    private String mDefaultTranslation;

    // Miwok Translation for word
    private String mMiwokTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    //Audio resource id for the word
    private int mAudioResourceId;


    // create a new word object

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;

    }


    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId,int audioResourceId) {
                mDefaultTranslation = defaultTranslation;
                mMiwokTranslation = miwokTranslation;
                mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
            }

    // get the default translation of word
    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }


    // get the miwok translation for word
    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }


    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
         * Returns whether or not there is an image for this word.
         */
     public boolean hasImage() {
               return mImageResourceId != NO_IMAGE_PROVIDED;
            }

            //return the audio resource id of the word

            public int getmAudioResourceId(){

                return mAudioResourceId;
            }
}


