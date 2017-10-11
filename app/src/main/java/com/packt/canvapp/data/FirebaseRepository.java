package com.packt.canvapp.data;

import android.content.Context;

import com.packt.canvapp.models.CanvasElementsModel;
import com.packt.canvapp.models.CanvasListModel;
import com.packt.canvapp.models.Canvas;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class FirebaseRepository implements IRemoteRepository {

    private Firebase reference;
    private Context context;

    public FirebaseRepository(Context context){
        Firebase.setAndroidContext(context);
        this.context = context;
        reference = new Firebase("https://torrid-heat-3108.firebaseio.com/canvapp/");
    }

    @Override
    public Canvas createCanvas() {
        Firebase ref = reference.child("canvases");
        Canvas canvas = new Canvas();
        CanvasElementsModel model= LocalRepository.getElements(context);
        canvas.ELEMENTS= model.ELEMENTS;
        Firebase postRef = ref.push();
        postRef.setValue(canvas);
        canvas.setId(postRef.getKey());
        return canvas;
    }

    @Override
    public void saveCanvasModel(Canvas model) {
        Firebase ref = reference.child("canvases").child(model.getId());
        ref.setValue(model);
    }

    @Override
    public void loadCanvasModels(final OnRepositoryResult handler) {
        Firebase ref = reference.child("canvases");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                CanvasListModel model = new CanvasListModel();
                for (DataSnapshot canvasSnapshot: snapshot.getChildren()) {
                    Canvas canvas = canvasSnapshot.getValue(Canvas.class);
                    canvas.setId(canvasSnapshot.getKey());
                    model.canvases.add(canvas);
                }
                handler.onResult(model);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }
}
