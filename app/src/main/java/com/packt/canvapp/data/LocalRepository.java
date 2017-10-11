package com.packt.canvapp.data;

import android.content.Context;
import com.packt.canvapp.R;
import com.packt.canvapp.models.CanvasElementsModel;
import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class LocalRepository {

    private LocalRepository(){
    }

    public static CanvasElementsModel getElements(Context context){
        Reader reader = getStreamReaderForRawAsset(context,R.raw.canvas);
        return new Gson().fromJson(reader, CanvasElementsModel.class);
    }

    private static InputStreamReader getStreamReaderForRawAsset(Context context, int resId){
        InputStream stream = context.getResources().openRawResource(resId);
        return new InputStreamReader(stream);
    }
}
