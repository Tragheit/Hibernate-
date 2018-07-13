package tragheit.jpa.tutorial.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DateTime {

	@Id
	private long id;

	// s¹ to wrapery na obiekty typu java.util.Date oraz java.util.Calendar
	// do przechowywania daty
	private java.sql.Date date;
	// do przechowywania czasu
	private java.sql.Time time;
	// do przechowywanie daty i czasu
	private java.sql.Timestamp timestamp;

	// domyœlne obiekty do obs³ugi daty i czasu
	// dyrektywa @Temporal pozwala na ustalenie jaki typ wartoœci zostanie nadany
	// zmiennej
	@Temporal(TemporalType.DATE)
	private java.util.Date utilDate;
	@Temporal(TemporalType.TIME)
	private java.util.Date utilTime;
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date utilTimestamp;

	// @Temporal dzia³a identycznie dla .Calendar
	@Temporal(TemporalType.DATE)
	private java.util.Calendar calendar;

	public java.util.Date getUtilDate() {
		return utilDate;
	}

	public void setUtilDate(java.util.Date utilDate) {
		this.utilDate = utilDate;
	}

	public java.util.Date getUtilTime() {
		return utilTime;
	}

	public void setUtilTime(java.util.Date utilTime) {
		this.utilTime = utilTime;
	}

	public java.util.Date getUtilDataTime() {
		return utilTimestamp;
	}

	public void setUtilDataTime(java.util.Date utilDataTime) {
		this.utilTimestamp = utilDataTime;
	}

	public java.util.Calendar getUtilCalendar() {
		return calendar;
	}

	public void setUtilCalendar(java.util.Calendar calendar) {
		this.calendar = calendar;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public java.sql.Time getTime() {
		return time;
	}

	public void setTime(java.sql.Time time) {
		this.time = time;
	}

	public java.sql.Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(java.sql.Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
