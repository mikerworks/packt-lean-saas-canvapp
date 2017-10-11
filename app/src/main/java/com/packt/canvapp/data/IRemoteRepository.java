package com.packt.canvapp.data;

import com.packt.canvapp.models.Canvas;

/**
 * Interface for some remote repository, in our example this is
 * Firebase (see FireBaseRepository implementation)
 */
public interface IRemoteRepository {
    Canvas createCanvas();
    void loadCanvasModels(OnRepositoryResult handler);
    void saveCanvasModel(Canvas model);
}
