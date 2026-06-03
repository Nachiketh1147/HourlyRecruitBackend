package com.hourlyrecruit.dto;

import java.util.List;

import com.hourlyrecruit.model.Testimonial;
import com.hourlyrecruit.model.TestimonialSection;

public class TestimonialResponse {

    private TestimonialSection section;

    private List<Testimonial> testimonials;

    public TestimonialResponse() {
    }

    public TestimonialResponse(
            TestimonialSection section,
            List<Testimonial> testimonials) {

        this.section = section;
        this.testimonials = testimonials;
    }

    public TestimonialSection getSection() {
        return section;
    }

    public void setSection(TestimonialSection section) {
        this.section = section;
    }

    public List<Testimonial> getTestimonials() {
        return testimonials;
    }

    public void setTestimonials(List<Testimonial> testimonials) {
        this.testimonials = testimonials;
    }
}