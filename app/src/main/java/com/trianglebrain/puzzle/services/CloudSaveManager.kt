package com.trianglebrain.puzzle.services

import android.app.Activity
import com.google.android.gms.games.PlayGames
import com.google.android.gms.games.snapshot.Snapshot
import com.google.android.gms.games.snapshot.SnapshotMetadataChange

object CloudSaveManager {

    private const val SAVE_NAME = "triangle_save"

    fun saveGame(activity: Activity, data: ByteArray) {

        val snapshotsClient = PlayGames.getSnapshotsClient(activity)

        snapshotsClient.open(SAVE_NAME, true)
            .addOnSuccessListener { result ->

                val snapshot: Snapshot = result.data
                snapshot.snapshotContents.writeBytes(data)

                val metadata = SnapshotMetadataChange.Builder()
                    .setDescription("Autosave")
                    .build()

                snapshotsClient.commitAndClose(snapshot, metadata)
            }
    }
}
