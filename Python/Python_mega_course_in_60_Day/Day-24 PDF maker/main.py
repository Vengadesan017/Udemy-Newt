from fpdf import FPDF
import pandas as df
from pandas.io.sas.sas_constants import magic

pdf = FPDF(orientation="P", unit="mm", format="A4")
pdf.set_auto_page_break(auto=False,margin=0)
data = df.read_csv("data.csv", sep=";")
for i , row in data.iterrows():
    pdf.add_page()
    pdf.set_font(family="Times", style="B", size=14)
    pdf.set_text_color(0,0,0)
    pdf.cell(w=0, h=12, txt=row["title"] , align="C",ln=1,border=1)
    pdf.cell(w=0, h=12, txt=row["description"] , align="L",ln=1)
    pdf.line(10, 51,200,55)
    pdf.ln(265)
    pdf.set_font(family="Times", style="I",size=8)
    pdf.set_text_color(180,180,180)
    pdf.cell(w=0, h=10,txt="vengat",align="R",ln=1)
pdf.output("output.pdf")



