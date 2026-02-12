package com.trianglebrain.puzzle.game

import kotlin.random.Random

class ParticleSystem {

    private val particles = mutableListOf<Particle>()

    fun emit(x: Float, y: Float, count: Int = 8) {
        repeat(count) {
            particles.add(
                Particle(
                    x = x,
                    y = y,
                    velocityX = Random.nextFloat() - 0.5f,
                    velocityY = Random.nextFloat() - 0.5f,
                    life = 1f
                )
            )
        }
    }

    fun update(delta: Float) {

        val iterator = particles.iterator()

        while (iterator.hasNext()) {
            val p = iterator.next()

            p.x += p.velocityX * delta * 100
            p.y += p.velocityY * delta * 100
            p.life -= delta

            if (p.life <= 0f) {
                iterator.remove()
            }
        }
    }

    fun particles(): List<Particle> = particles
}

data class Particle(
    var x: Float,
    var y: Float,
    val velocityX: Float,
    val velocityY: Float,
    var life: Float
)
