package hunre.it.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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

	private LocalDate ngayMuon;

	private int soNgayMuon;

	private LocalDate ngayTra;

	private String tenSinhVienMuon;

}
