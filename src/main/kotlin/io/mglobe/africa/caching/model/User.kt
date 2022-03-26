package io.mglobe.africa.caching.model

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import java.io.Serializable
import javax.persistence.*

/**
 * Created by sakawabob on 26/03/2022.
 */
@Entity
@Table(name ="user")
@DynamicInsert
@DynamicUpdate
class User: Serializable {
    private val serialVersionUID = 7156526077883281623L
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null
    var name: String? = null
    var followers: Long? = null
}