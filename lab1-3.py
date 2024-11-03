import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

# Example data
data = {
    'L': [0.15, 0.17, 0.19, 0.21, 0.23, 0.25],  # L values in meters
    'T_avg_10': [
        [6.91, 6.79, 6.86, 6.8, 6.88, 6.85, 6.86, 6.78, 6.79, 6.94],
        [8.01, 8.02 , 8.02, 8.00, 7.82, 7.88, 8.10, 7.91, 8.01, 8.03],
        [8.43, 8.59, 8.63, 8.92, 8.74, 8.74, 8.47, 8.69, 8.91, 8.64],
        [9.19, 9.21, 9.24, 9.32, 9.02, 9.44, 9.18, 9.34, 9.11, 9.14],
        [9.63, 9.44, 9.41, 9.63, 9.43, 9.44, 9.37, 9.42, 9.54, 9.55],
        [9.81, 9.89, 10.01, 10.03, 10.02, 9.84, 9.83, 9.91, 9.85, 10.01]
    ]
}

df = pd.DataFrame(data)
constant_uncertainty_T = 0.6
constant_uncertainty_L = 0.05

# Calculate average and uncertainty for T_avg_10
df['T_avg_10_mean'] = df['T_avg_10'].apply(np.mean)
df['T_avg_10_std'] = df['T_avg_10'].apply(np.std, ddof=1)
n = 10
df['T_avg_10_error'] = df['T_avg_10_std'] / np.sqrt(n) + constant_uncertainty_T

# Define the x-axis as 2*pi*sqrt(L)
pi = np.pi
df['x_value'] = 2 * pi * np.sqrt(df['L'])
df['x_error'] = (pi * constant_uncertainty_L) / np.sqrt(df['L'])

# Use T_avg_10_mean directly for T (in seconds)
df['T'] = df['T_avg_10_mean'] / 10
df['T_errors'] = df['T_avg_10_error'] / 10  # Adjust T errors

# Calculate g and its error
df['g'] = (4 * pi**2 * df['L']) / df['T']**2
L_errors = np.full_like(df['L'], constant_uncertainty_L, dtype=float)
df['g_error'] = np.sqrt((4 * pi**2 / df['T']**2)**2 * L_errors**2 + (8 * pi**2 * df['L'] / df['T']**3)**2 * df['T_errors']**2)

# Calculate mean and uncertainty of g
g_mean = df['g'].mean()
g_error_mean = np.sqrt(np.sum(df['g_error']**2)) / len(df)

# Check g values
print("g_mean:", g_mean, "g_error_mean:", g_error_mean)

# Plot T against the new x-axis with error bars
plt.figure(figsize=(10, 6))
plt.errorbar(df['x_value'], df['T'], yerr=df['T_errors'], xerr=df['x_error'], fmt='o',
             color='blue', label='T', capsize=5)

# Fit a line of best fit
slope, intercept = np.polyfit(df['x_value'], df['T'], 1)
x_fit = np.linspace(min(df['x_value']) - 0.5, max(df['x_value']) + 0.5, 100)
T_fit = slope * x_fit + intercept
plt.plot(x_fit, T_fit, color='red', label=f'Best Fit: T = {slope:.2f} * x + {intercept:.2f}')

# Calculate R² for the fit
ss_tot = np.sum((df['T'] - np.mean(df['T'])) ** 2)
ss_res = np.sum((df['T'] - (slope * df['x_value'] + intercept)) ** 2)
r_squared = 1 - (ss_res / ss_tot)

# Add R² and g to the legend
plt.legend(title=f'R² = {r_squared:.4f}\n'
                 f'g = {g_mean:.4f} ± {g_error_mean:.4f} m/s²')

# Set limits for x and y axes for better visualization
plt.xlim(min(df['x_value']) - 0.5, max(df['x_value']) + 0.5)
plt.ylim(min(df['T']) - 0.15, max(df['T']) + 0.15)

# Labels and title
plt.xlabel(r'$2\pi\sqrt{L}$ (with uncertainty)')
plt.ylabel('T (with uncertainty)')
plt.title(r'Graph of $T$ vs $2\pi\sqrt{L}$ with Error Propagation')
plt.grid()
plt.show()
