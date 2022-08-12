package com.varxyz.wgt.board.domain;

import java.awt.Image;

import com.varxyz.wgt.user.domain.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(
		uniqueConstraints = {
				@UniqueConstraint(
						name="likes_uk",
						columnNames = {"imgName", "userId"}
				)
		}
)
public class Likes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="imgName")
	@ManyToOne
	private Image image; 
	
	@JoinColumn(name="userId")
	@ManyToOne
	private User user; 



}