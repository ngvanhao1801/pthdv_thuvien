package hunre.it.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_thuvien")
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maSach;

	private String tenSach;

	private String ngayMuon;

	private int soNgayMuon;

	private String ngayTra;

	private String tenSinhVienMuonSach;

}
