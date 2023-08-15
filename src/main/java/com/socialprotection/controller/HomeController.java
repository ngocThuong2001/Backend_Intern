package com.socialprotection.controller;

import java.sql.Timestamp;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.socialprotection.entity.Donation;
import com.socialprotection.entity.Donor;
import com.socialprotection.repository.BudgetRepository;
import com.socialprotection.repository.JobRepository;
import com.socialprotection.repository.ShiftRepository;
import com.socialprotection.service.ChildrenService;
import com.socialprotection.service.DonationService;
import com.socialprotection.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;

	@Autowired
	ChildrenService childrenService;

	@Autowired
	private BudgetRepository budgetRepository;

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private ShiftRepository shiftRepository;

	@Autowired
	private DonationService donationService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public void homePage() {
		String[] fname = { "An", "Anh", "Ban", "Bình", "Bích", "Băng", "Bạch", "Bảo", "Bằng", "Bội", "Ca", "Cam", "Chi",
				"Chinh", "Chiêu", "Chung", "Châu", "Cát", "Cúc", "Cương", "Cầm", "Cẩm", "Dao", "Di", "Diên", "Diễm",
				"Diệp", "Diệu", "Du", "Dung", "Duy", "Duyên", "Dân", "Dã", "Dương", "Dạ", "Gia", "Giang", "Giao",
				"Giáng", "Hiếu", "Hiền", "Hiểu", "Hiệp", "Hoa", "Hoan", "Hoài", "Hoàn", "Hoàng", "Hoạ", "Huyền", "Huệ",
				"Huỳnh", "Hà", "Hàm", "Hân", "Hòa", "Hương", "Hướng", "Hường", "Hưởng", "Hạ", "Hạc", "Hạnh", "Hải",
				"Hảo", "Hậu", "Hằng", "Họa", "Hồ", "Hồng", "Hợp", "Khai", "Khanh", "Khiết", "Khuyên", "Khuê", "Khánh",
				"Khê", "Khôi", "Khúc", "Khả", "Khải", "Kim", "Kiết", "Kiều", "Kê", "Kỳ", "Lam", "Lan", "Linh", "Liên",
				"Liễu", "Loan", "Ly", "Lâm", "Lê", "Lý", "Lăng", "Lưu" };
		String[] lname = { "Đặng", "Tô", "Đồng", "Vi", "Lã", "Đỗ", "Vương", "Danh", "Biện", "Trình", "Ngô", "Văn", "Lư",
				"Hàng", "Ninh", "Hồ", "Tăng", "Lữ", "Ôn", "Nhâm", "Dương", "Quách", "Thân", "Chế", "Tôn Nữ", "Đinh",
				"Lại", "Kim", "Thi", "Doãn", "Đoàn", "Hứa", "Mã", "Ông", "Khổng", "Lâm", "Thạch", "Bạch", "Tôn Thất",
				"Phù", "Mai", "Diệp", "Liêu", "Ngụy", "Đường", "Trịnh", "Từ", "Tiêu", "Viên", "Tào", "Đào", "Chu", "Dư",
				"Kha", "Cù" };
		String[] pn = { "1212310380", "1216629337", "1214246408", "1212180441", "1212120981", "1213901758",
				"1211113882", "1217141116", "1217942269", "1216333843", "1210391766", "1211140415", "1214092473",
				"1218661177", "1210019129", "1211282321", "1217204257", "1216553887", "1214076397", "1219483762",
				"1218829275", "1214767825", "1219566964", "1214299440", "1219831691", "1211862378", "1216414518",
				"1210359239", "1212781844", "1216735089", "1218034777", "1215629894" };
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date;
		try {
			date = (Date) formatter.parse("02-07-2022");
			Timestamp timestamp = new java.sql.Timestamp(date.getTime());
			System.out.println(timestamp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

//		System.out.println(fname.length + lname.length);

//		for (int i = 0; i < 50; i++) {
//			for (int j = 0; j < 50; j++) {
//				Donor donor = new Donor();
//				donor.setFirstName(fname[i]);
//				donor.setLastName(lname[j]);
//				donor.setFullName(lname[j] + " " + fname[i]);
//
//				String temp = Normalizer.normalize(donor.getFullName(), Normalizer.Form.NFD);
//				Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
//				String em = pattern.matcher(temp).replaceAll("").toLowerCase();
//				String email = em.replaceAll(" ", "");
//
//				donor.setEmail(email + "@gmail.com");
//
//				donor.setPhoneNumber(pn[(int) Math.floor(Math.random() * pn.length)]);
//
//				Donation donation = new Donation();
//
//				Donor donorSaved = donationService.saveDonor(donor);
//
//				donation.setDonor(donorSaved);
//
//				long amount = (long) Math.floor(Math.random() * 1000000);
//
//				donation.setAmount(amount);
//				donation.setReason("Cho em");
//				donation.setStatus('0');
//				donation.setBankCode("NCB");
//				donation.setBankTranNo("VNP" + amount);
//				donation.setCardType("ATM");
//				donation.setVnpayTranNo((long) Math.floor(Math.random() * 1000000) + "");
//
//				long offset = Timestamp.valueOf("2018-01-01 00:00:00").getTime();
//				long end = Timestamp.valueOf("2023-08-12 00:00:00").getTime();
//				long diff = end - offset + 1;
//				Timestamp rand = new Timestamp(offset + (long) (Math.random() * diff));
//				donation.setDonateTime(rand);
//
//				System.out.println(donationService.saveDonation(donation));
//
//			}
//		}

//		Role role = userService.saveRole(new Role("SUPER_ADMIN","Quyền quản trị cao nhất, có quyền quản lý tài khoản admin"));
//		Role role2 = userService.saveRole(new Role("ADMIN", "Quyền quản trị hệ thống, thực hiện thêm, sửa, xóa các thông tin của trung tâm"));
//		Role role3 = userService.saveRole(new Role("WEB_ADMIN", "Quyền quản trị website, thêm sửa xóa các bài viết và nội dung hiển thị trên website"));
//
//		userService.saveUser(new User("SUPERADMIM01", "superadmin@01", role));
//
//		userService.saveUser(new User("ADMIN01", "admin@01", role2));
//		userService.saveUser(new User("ADMIN03", "admin@03", role3));
//
//		childrenService.saveTypeOrphan(new TypeOfOrphan("Trẻ mồ côi cha mẹ",
//				"Đây là loại trẻ mồ côi phổ biến nhất, khi cha mẹ của chúng đã qua đời hoặc không thể nuôi dưỡng chúng vì nhiều lý do khác nhau, bao gồm chiến tranh, bạo lực gia đình hay bệnh tật."));
//		childrenService.saveTypeOrphan(
//				new TypeOfOrphan("Trẻ mồ côi cha", "Trẻ mồ côi loại này chỉ mất cha do tử vong hoặc bỏ rơi."));
//		childrenService.saveTypeOrphan(
//				new TypeOfOrphan("Trẻ mồ côi mẹ", "Trẻ mồ côi loại này chỉ mất mẹ do tử vong hoặc bỏ rơi."));
//		childrenService.saveTypeOrphan(new TypeOfOrphan("Trẻ mồ côi vì bố mẹ ly dị hoặc bị bỏ rơi",
//				"Trẻ mồ côi loại này có thể do cha mẹ ly dị, bị bỏ rơi hoặc không có ai chịu trách nhiệm nuôi dưỡng"));
//		childrenService.saveTypeOrphan(new TypeOfOrphan("Trẻ mồ côi do bạo lực gia đình",
//				"Những trẻ mồ côi này thường là nạn nhân của bạo lực gia đình, bị cha mẹ hoặc người giám hộ bạo hành hoặc bỏ rơi"));
//		childrenService.saveTypeOrphan(new TypeOfOrphan("Trẻ mồ côi do cha mẹ bị bắt tù",
//				"Trẻ mồ côi loại này là con của phạm nhân bị bắt tù, không có ai chịu trách nhiệm nuôi dưỡng."));
//
//		childrenService.saveTypeOrphan(new TypeOfOrphan("Trẻ mồ côi cha mẹ",
//				"Đây là loại trẻ mồ côi phổ biến nhất, khi cha mẹ của chúng đã qua đời hoặc không thể nuôi dưỡng chúng vì nhiều lý do khác nhau, bao gồm chiến tranh, bạo lực gia đình hay bệnh tật."));
//		childrenService.saveTypeOrphan(
//				new TypeOfOrphan("Trẻ mồ côi cha", "Trẻ mồ côi loại này chỉ mất cha do tử vong hoặc bỏ rơi."));
//		childrenService.saveTypeOrphan(
//				new TypeOfOrphan("Trẻ mồ côi mẹ", "Trẻ mồ côi loại này chỉ mất mẹ do tử vong hoặc bỏ rơi."));
//		childrenService.saveTypeOrphan(new TypeOfOrphan("Trẻ mồ côi vì bố mẹ ly dị hoặc bị bỏ rơi",
//				"Trẻ mồ côi loại này có thể do cha mẹ ly dị, bị bỏ rơi hoặc không có ai chịu trách nhiệm nuôi dưỡng"));
//		childrenService.saveTypeOrphan(new TypeOfOrphan("Trẻ mồ côi do bạo lực gia đình",
//				"Những trẻ mồ côi này thường là nạn nhân của bạo lực gia đình, bị cha mẹ hoặc người giám hộ bạo hành hoặc bỏ rơi"));
//		childrenService.saveTypeOrphan(new TypeOfOrphan("Trẻ mồ côi do cha mẹ bị bắt tù",
//				"Trẻ mồ côi loại này là con của phạm nhân bị bắt tù, không có ai chịu trách nhiệm nuôi dưỡng."));
//
//		childrenService
//				.saveChildrenStatus(new ChildrenStatus("Đang được bảo trợ", "Trẻ em vẫn đang được bảo trợ"));
//		childrenService.saveChildrenStatus(new ChildrenStatus("Đã được nhận nuôi", "Trẻ em đã được nhận nuôi"));
//		childrenService.saveChildrenStatus(new ChildrenStatus("Đã quá tuổi", "Trẻ em đã quá tuổi"));
//
//		jobRepository.save(new Job("Chăm sóc trẻ",
//				"- Chăm sóc và nuôi dưỡng các trẻ em mồ côi. Chia sẻ cuộc sống của mình với các con, chăm sóc, nuôi dạy, che chở và mang lại cho các con cơ hội phát triển, những mối quan hệ mới, lâu dài và tình thương yêu trong gia đình SOS của mình."));
//		jobRepository.save(new Job("Nấu ăn", "Nấu ăn"));
//
//		shiftRepository.save(new Shift("Ca 1", new Time(6, 0, 0), new Time(14, 0, 0)));
//		shiftRepository.save(new Shift("Ca 2", new Time(14, 0, 0), new Time(22, 0, 0)));
//		shiftRepository.save(new Shift("Ca 3", new Time(22, 0, 0), new Time(6, 0, 0)));
//
//		budgetRepository.save(new Budget("tien quy", "xay dung", 10000, null, null));
//		budgetRepository.save(new Budget("tien an", "an uong", 20000, null, null));
	}
}