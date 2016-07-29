/**
 * 
 */
package com.catsvie.libra.security.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * POJO Entity for table "STORE_PERMISSION"
 * 
 * @author Peng Wang <br/>
 *         Jul 29, 2016
 * @version 1.0 <br/>
 */
@Entity(name = "USER_STORE_PERMISSION")
@Table(name = "USER_STORE_PERMISSION")
public class UserStorePermissionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "storePermissionId")
	private long id;

	@ManyToOne
	private UserEntity user;
}
