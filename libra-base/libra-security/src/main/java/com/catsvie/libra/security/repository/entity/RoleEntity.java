/**
 * 
 */
package com.catsvie.libra.security.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Role enum.
 * 
 * @author Peng Wang <br/>
 *         Jul 29, 2016
 * @version 1.0 <br/>
 */
@Entity(name = "ROLE")
@Table(name = "ROLE")
public class RoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roleId")
	private long roleId;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;
}
