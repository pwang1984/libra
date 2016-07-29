/**
 * 
 */
package com.catsvie.libra.security.repository.entity;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * POJO entity for table "USER"
 * @author Peng Wang <br/>
 *         Jul 28, 2016
 * @version 1.0 <br/>
 */
@Entity(name = "USER")
@Table(name = "USER")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany
	@JoinTable(name = "USER_ROLE", joinColumns = {
			@JoinColumn(name = "userId", referencedColumnName = "userId")
	}, inverseJoinColumns = {
			@JoinColumn(name = "roleId", referencedColumnName = "roleId")
	})
	//	@Convert(converter = RoleEntityConverter.class)
	@ElementCollection(targetClass = RoleEntity.class, fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING) // Possibly optional (I'm not sure) but defaults to ORDINAL.
	@CollectionTable(name = "person_roles")
	@Column(name = "role")
	private Set<RoleEntity> roleSet;
	
	@OneToMany(mappedBy = "user")
	@PrimaryKeyJoinColumn (name = "userId", referencedColumnName = "userId")
	private Set<UserStorePermissionEntity> storePermissionSet;
}
